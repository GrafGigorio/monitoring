import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.DigestScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

public class Req {
    private final Log log = LogFactory.getLog(getClass());

    protected static String downloadDigest(URL url, User user)
            throws IOException {

        HttpHost targetHost = new HttpHost(url.getHost(), url.getPort(), url.getProtocol());

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpClientContext context = HttpClientContext.create();

        String userLc = user.login;
        String passwordLC = user.pass;

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(userLc, passwordLC));
        AuthCache authCache = new BasicAuthCache();
        DigestScheme digestScheme = new DigestScheme();
        authCache.put(targetHost, digestScheme);

        context.setCredentialsProvider(credsProvider);
        context.setAuthCache(authCache);

        RequestConfig rf = RequestConfig.custom().setConnectTimeout(1000).build();

        HttpGet httpget = new HttpGet(url.getPath());
        httpget.setConfig(rf);
        CloseableHttpResponse response = httpClient.execute(targetHost, httpget, context);//тут красные строчки
        try {
            byte[] ds = response.getEntity().getContent().readAllBytes();
            StringBuilder sb = new StringBuilder();
            for (byte d : ds) {
                sb.append((char) d);
            }
            return sb.toString();
        } finally {
            response.close();
        }
    }
}
