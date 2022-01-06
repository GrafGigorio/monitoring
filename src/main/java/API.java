
import java.net.*;
import java.io.*;

class API
{
    public String resp;
    static private final int MAXRECEIVESIZE = 65535;

    static private Socket socket = null;

    private void closeAll() throws Exception
    {
        if (socket != null)
        {
            socket.close();
            socket = null;
        }
    }
    private static void closeAlld() throws Exception
    {
        if (socket != null)
        {
            socket.close();
            socket = null;
        }
    }

    public String display(String result) throws Exception
    {
        String value;
        String name;
        StringBuilder resp =new StringBuilder("{\"main\":[");
        String[] sections = result.split("\\|", 0);

        for (int i = 0; i < sections.length; i++)
        {
            if (sections[i].trim().length() > 0)
            {
                String[] data = sections[i].split(",", 0);

                for (int j = 0; j < data.length; j++)
                {
                    String[] nameval = data[j].split("=", 2);

                    if (j == 0)
                    {
                        if (nameval.length > 1
                                &&  Character.isDigit(nameval[1].charAt(0)))
                            name = nameval[0] + nameval[1];
                        else
                            name = nameval[0];
                        resp.append("\n");
//                        resp.append("\"" + (name == "" ? "ept" : name) + "\":\n");
                        resp.append("   {\n");
                    }

                    if (nameval.length > 1)
                    {
                        name = nameval[0];
                        value = nameval[1];
                    }
                    else
                    {
                        name = "" + j;
                        value = nameval[0];
                    }
                    if(     !value.equals("") &&
                            !value.equals("0") &&
                            !value.equals("0-0-0-0") &&
                            !value.equals("0.00") &&
                            !value.equals("0.000000")&&
                            !value.equals("{}"))
                        resp.append("      \""+name.replace(" ", "_")+"\": \""+value.
                                replace(" ", "_")+"\",\n");
                }
                resp.replace(resp.length()-2,resp.length()-1,"");
                resp.append("   },");
            }
        }
        resp.replace(resp.length()-1,resp.length(),"");
        resp.append("\n]}");
        String rq = resp.toString();

        rq = rq.replace("freq_avg1","freq1");
        rq = rq.replace("freq_avg2","freq2");
        rq = rq.replace("freq_avg3","freq3");

//        rq.replace("freq1","freq_avg1");
//        rq.replace("freq2","freq_avg2");
//        rq.replace("freq3","freq_avg3");

        return rq;
    }

    public String process(String cmd, InetAddress ip, int port) throws Exception
    {
        StringBuffer sb = new StringBuffer();
        char buf[] = new char[MAXRECEIVESIZE];
        int len = 0;

        System.out.println("Attempting to send '"+cmd+"' to "+ip.getHostAddress()+":"+port);

        try
        {
            //socket = new Socket(ip, port);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 200);

            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.print(cmd.toCharArray());
            ps.flush();

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());

            while (0x80085 > 0)
            {
                len = isr.read(buf, 0, MAXRECEIVESIZE);
                if (len < 1)
                    break;
                sb.append(buf, 0, len);
                if (buf[len-1] == '\0')
                    break;
            }

            closeAll();
        }
        catch (IOException ioe)
        {
            System.err.println(ioe.toString());
            closeAll();
            return null;
        }

        String result = sb.toString();

//        System.out.println();
//        System.out.println("Answer='"+result+"'");
//        System.out.println();
        return display(result);
    }

    public API(String command, String _ip, String _port) throws Exception
    {
        InetAddress ip;
        int port;

        try
        {
            ip = InetAddress.getByName(_ip);
        }
        catch (UnknownHostException uhe)
        {
            System.err.println("Unknown host " + _ip + ": " + uhe);
            return;
        }

        try
        {
            port = Integer.parseInt(_port);
        }
        catch (NumberFormatException nfe)
        {
            System.err.println("Invalid port " + _port + ": " + nfe);
            return;
        }

        this.resp = process(command, ip, port).replace(" ","").replace("\n", "");
    }

    public static boolean ping(String _ip, String _port)
    {
        InetAddress ip;
        int port;
        int len = 0;
        char buf[] = new char[MAXRECEIVESIZE];
        StringBuffer sb = new StringBuffer();
        try
        {
            ip = InetAddress.getByName(_ip);
        }
        catch (UnknownHostException uhe)
        {
            System.err.println("Unknown host " + _ip + ": " + uhe);
            return false;
        }

        try
        {
            port = Integer.parseInt(_port);
        }
        catch (NumberFormatException nfe)
        {
            System.err.println("Invalid port " + _port + ": " + nfe);
            return false;
        }

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 200);
            socket.close();
        } catch (SocketTimeoutException e) {

            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  true;
    }

}