package ch.ojeker.leaflet_jmix.web.screens;

import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.gui.components.JavaScriptComponent;

import javax.inject.Inject;

@UiController("leafletjmix_LeafletIntegrated")
@UiDescriptor("leaflet-integrated.xml")
public class LeafletIntegrated extends Screen {
    @Inject
    private JavaScriptComponent leaflet;
}