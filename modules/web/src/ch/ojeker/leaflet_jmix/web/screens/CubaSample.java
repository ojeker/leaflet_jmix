package ch.ojeker.leaflet_jmix.web.screens;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.gui.components.JavaScriptComponent;

import javax.inject.Inject;
import java.io.Serializable;

@UiController("leafletjmix_CubaSample")
@UiDescriptor("cuba_sample.xml")
public class CubaSample extends Screen {
    @Inject
    private JavaScriptComponent timePicker;
    @Inject
    private Notifications notifications;

    @Subscribe
    protected void onInit(InitEvent event) {
        TimePickerState state = new TimePickerState();
        state.now = "12:35:57";
        state.showSeconds = true;
        state.twentyFour = true;

        timePicker.addFunction("onBeforeShow", callbackEvent ->
                notifications.create()
                        .withCaption("Before Show Event")
                        .withPosition(Notifications.Position.MIDDLE_RIGHT)
                        .show());

        timePicker.addFunction("onShow", callbackEvent ->
                notifications.create()
                        .withCaption("Show Event")
                        .show());

        timePicker.setState(state);
    }

    @Subscribe("showValueBtn")
    protected void onShowValueBtnClick(Button.ClickEvent event) {
        timePicker.callFunction("showValue");
    }

    public class TimePickerState implements Serializable {
        public String now;             // hh:mm 24 hour format only, defaults to current time
        public boolean twentyFour;     // Display 24 hour format, defaults to false
        public boolean showSeconds;    // Whether or not to show seconds
    }
}