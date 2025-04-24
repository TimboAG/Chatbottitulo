package com.titulos.unne.servicioImpl;

import com.titulos.unne.servicio.ScraperServicio;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

@Service
public class ScraperServicioImpl implements ScraperServicio {


    @Override
    public String obtenerContenidoTituloUNNE() {
        try {
            // Ignorar validaciones SSL (SOLO PARA LOCAL)
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                    public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

            // Conexión a la página
            String url = "https://exa.unne.edu.ar/r/?page_id=9008";
            Document doc = Jsoup.connect(url).get();

            // Extraer solo el contenido dentro del div.entry-content
            String textoPlano = doc.select("div.entry-content").text();

            // Formateo opcional (como ya tenías)
            return textoPlano
                .replaceAll("(?i)(PASO \\d+:)", "\n\n🔹 $1")
                .replaceAll("(?i)(OPCIONAL[-–])", "\n\n📌 $1")
                .replaceAll("(?i)(PROCEDIMIENTO.*?)\\:", "\n\n📝 $1:")
                .replaceAll("(\\d+\\-)", "\n$1")
                .replaceAll("(?i)(Certificado de Título.*?Trámite)", "\n\n📄 $1")
                .replaceAll("(?i)(Resolución \\d{3,4}/\\d{2} – [A-Z])", "\n📎 $1")
                .replaceAll("(?i)(https?://\\S+)", "\n🌐 $1")
                .replaceAll("(?i)(Nombre de archivo\\:)", "\n📂 $1");

        } catch (Exception e) {
            e.printStackTrace();
            return "⚠️ No se pudo obtener la información desde la página.";
        }
    }
}



