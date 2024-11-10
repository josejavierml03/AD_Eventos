package servicioEventos;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dominio.PuntoDeInteres;

public class PuntosDeInteres implements IPuntosDeInteres {

    private static final String USERNAME = "aadd"; // Cambiar por el usuario de la asignatura o uno propio

    public List<PuntoDeInteres> obtenerPuntosDeInteres(double latitud, double longitud) {
        List<PuntoDeInteres> puntosDeInteres = new ArrayList<>();
        String urlString = String.format(
            "http://api.geonames.org/findNearbyWikipedia?username=%s&lang=ES&lat=%f&lng=%f",
            USERNAME, latitud, longitud
        );

        try {
            // Crear la conexión
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Procesar la respuesta XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(connection.getInputStream());

            // Obtener nodos 'entry'
            NodeList entries = doc.getElementsByTagName("entry");

            for (int i = 0; i < entries.getLength(); i++) {
                Node node = entries.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Extraer datos del punto de interés
                    String nombre = getTagValue("title", element);
                    String descripcion = getTagValue("summary", element);
                    double distancia = Double.parseDouble(getTagValue("distance", element));
                    String urlWikipedia = getTagValue("wikipediaUrl", element);

                    // Crear objeto PuntoDeInteres
                    PuntoDeInteres punto = new PuntoDeInteres(
                        nombre,
                        descripcion != null ? descripcion : "",
                        distancia,
                        "https://" + urlWikipedia
                    );
                    puntosDeInteres.add(punto);
                }
            }

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        return puntosDeInteres;
    }

    // Método auxiliar para obtener el valor de un elemento XML
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                return node.getTextContent();
            }
        }
        return null;
    }
}

