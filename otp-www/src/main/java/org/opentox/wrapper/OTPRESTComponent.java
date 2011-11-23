package org.opentox.wrapper;

import net.idea.restnet.c.RESTComponent;

import org.restlet.Application;
import org.restlet.Context;

/**
 * This is used as a servlet component instead of the core one, to be able to attach protocols 
 * @author nina
 *
 */
public class OTPRESTComponent extends RESTComponent {
		public OTPRESTComponent() {
			this(null);
		}
		public OTPRESTComponent(Context context,Application[] applications) {
			super(context,applications);
			
		
		}
		public OTPRESTComponent(Context context) {
			this(context,new Application[]{new OTPApplication()});
		}
		
		

}
