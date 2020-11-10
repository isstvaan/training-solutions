package stringmethods.url;

/*
    https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2014-01-01&endtime=2014-01-02

    protocol: https (kötelező)
    host: earthquake.usgs.gov (kötelező)
    port: (nincs megadva)
    path: fdsnws/event/1/query
    query-stringként átadott adatok:
    format = geojson
    starttime = 2014-01-01
    endtime = 2014-01-02
     */

import java.util.SplittableRandom;

public class UrlManager {
    private String protocol;
    private int port;
    private String host;
    private String path;
    private String query;


    public UrlManager(String url) {
        protocol = getProtocolFromURL(url);
        port = getPortFromURL(url);
        host = getHostFromURL(url);
        path = getPathFromURL(url);
        query = getQueryFromURL(url);
    }

    private boolean parameterIsValid(String parameter) {
        return parameter != null && !parameter.isBlank();
    }

    private String getProtocolFromURL(String url) {
        if (!parameterIsValid(url) || url.indexOf("://") < 0) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return url.substring(0, url.indexOf("://")).toLowerCase();
    }

    public Integer getPortFromURL(String url) {
        if (!parameterIsValid(url)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int portIndex = url.indexOf(":", url.indexOf("://") + 3);
        if (portIndex < 0) {
            return null;
        }

        int portEndIndex = url.indexOf("/", portIndex);
        return Integer.valueOf(url.substring(portIndex + 1, (portEndIndex < 0 ? portIndex + 1 : portEndIndex)));

    }

    public String getHostFromURL(String url) {
        if (!parameterIsValid(url)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int hostIndex = url.indexOf(url.indexOf("://") + 3);
        int hostEndIndex = url.indexOf("/", hostIndex);

        String host = null;
        if (hostEndIndex < 0) {
            host = url.substring(hostIndex);
        } else {
            host = url.substring(hostIndex, hostEndIndex);
        }

        if (!parameterIsValid(host)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return host.toLowerCase();
    }

    public String getPathFromURL(String url) {
        if (!parameterIsValid(url)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        int pathStartIndex = url.indexOf(url.indexOf("://") + 3);
        pathStartIndex = url.indexOf("/", pathStartIndex);

        if (pathStartIndex < 0) {
            return "";
        }

        int pathEndIndex = url.indexOf("?", pathStartIndex);
        if (pathEndIndex < 0) {
            return url.substring(pathStartIndex);
        } else {
            return url.substring(pathStartIndex, pathEndIndex);
        }

    }

    public String getQueryFromURL(String url) {
        if (!parameterIsValid(url)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        String query = "";
        if (url.indexOf("query?") > 0) {
            return url.substring(url.indexOf("query?") + "query?".length());
        }

        return query;
    }

       public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    public boolean hasProperty(String key) {
        if (!parameterIsValid(key)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        return query.length() > 0;
    }

    public String getProperty(String key) {
        if (!parameterIsValid(key)) {
            throw new IllegalArgumentException("Invalid parameter");
        }

        String[] properties = query.split("&");
        for (int i = 0; i < properties.length; i++) {
            String[] keyValuesPairs = query.split("=");
            if (keyValuesPairs.length > 1) {
                if (keyValuesPairs[0].equalsIgnoreCase(key)) {
                    return keyValuesPairs[1];
                }
            }
        }
        return null;
    }

}
