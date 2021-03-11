package by.belinvest.panel.admin;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Test {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("http://www.example.com"));
    }
}
