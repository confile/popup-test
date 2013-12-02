package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndHandler;
import com.googlecode.mgwt.dom.client.event.touch.TouchMoveEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchMoveHandler;
import com.googlecode.mgwt.dom.client.event.touch.TouchStartEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchStartHandler;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort;
import com.googlecode.mgwt.ui.client.MGWTSettings.ViewPort.DENSITY;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.touch.TouchPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TestPopup implements EntryPoint {

	
	/**
	 * Resources that match the GWT standard style theme.
	 */
	public interface Resources extends ClientBundle {
	
		/**
		 * The styles used in this widget.
		 */
		@Source({ Css.DEFAULT_CSS })
		Css css();
	}
	
	public interface Css extends CssResource {
		/**
		 * The path to the default CSS styles used by this resource.
		 */
		String DEFAULT_CSS = "test/client/Test.css";

		String touchPanel();
		String popupPanel();
		String popupPanelTouch();
		String popupPanelShow();
	}

	
	Resources resources = GWT.create(Resources.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// set viewport and other settings for mobile
		ViewPort viewPort = new MGWTSettings.ViewPort();
		viewPort.setTargetDensity(DENSITY.MEDIUM);
	    viewPort.setUserScaleAble(false).setMinimumScale(1.0).setMinimumScale(1.0).setMaximumScale(1.0);
		MGWTSettings settings = new MGWTSettings();
		settings.setViewPort(viewPort);
		settings.setAddGlosToIcon(true);
		settings.setFullscreen(true);
		settings.setPreventScrolling(true);
		MGWT.applySettings(settings);
		
		resources.css().ensureInjected();
		
		// set the view
		LayoutPanel layoutPanel = new LayoutPanel();
		
		TouchPanel touchPanel = new TouchPanel();
		touchPanel.addStyleName(resources.css().touchPanel());
		layoutPanel.add(touchPanel);
		
		
		// set the popup
		final PopupPanel popupPanel = new PopupPanel();
		popupPanel.addStyleName(resources.css().popupPanel());
		LayoutPanel popupLayoutPanel = new LayoutPanel();
		popupPanel.add(popupLayoutPanel);
		TouchPanel popupTouchPanel = new TouchPanel();
		popupTouchPanel.addStyleName(resources.css().popupPanelTouch());
		popupLayoutPanel.add(popupTouchPanel);
		

		
		// add touchpanel handlers
		touchPanel.addTouchStartHandler(new TouchStartHandler() {
			
			@Override
			public void onTouchStart(TouchStartEvent event) {
				GWT.log("touchPanel onTouchStart");
				popupPanel.addStyleName(resources.css().popupPanelShow());
			}
		});
		
		touchPanel.addTouchMoveHandler(new TouchMoveHandler() {
			
			@Override
			public void onTouchMove(TouchMoveEvent event) {
				GWT.log("touchPanel onTouchMove");
				
			}
		});
		
		touchPanel.addTouchEndHandler(new TouchEndHandler() {
			
			@Override
			public void onTouchEnd(TouchEndEvent event) {
				GWT.log("touchPanel onTouchEnd");				
			}
		});
		
		touchPanel.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				GWT.log("touchPanel onTap");	
				
			}
		});
		
		
		// add popup handlers
		
		popupTouchPanel.addTouchStartHandler(new TouchStartHandler() {
			
			@Override
			public void onTouchStart(TouchStartEvent event) {
				GWT.log("popupTouchPanel onTouchStart");
			}
		});
		
		popupTouchPanel.addTouchMoveHandler(new TouchMoveHandler() {
			
			@Override
			public void onTouchMove(TouchMoveEvent event) {
				GWT.log("popupTouchPanel onTouchMove");
				
			}
		});
		
		popupTouchPanel.addTouchEndHandler(new TouchEndHandler() {
			
			@Override
			public void onTouchEnd(TouchEndEvent event) {
				GWT.log("popupTouchPanel onTouchEnd");				
			}
		});
		
		popupTouchPanel.addTapHandler(new TapHandler() {
			
			@Override
			public void onTap(TapEvent event) {
				GWT.log("popupTouchPanel onTap");	
				
			}
		});
		
		
		
		
		
		
		
		// add to root panel
		RootPanel.get().add(layoutPanel);
		RootPanel.get().add(popupPanel);
	}
}
