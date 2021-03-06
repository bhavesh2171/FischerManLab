/** 
 * Copyright (c) 2014 Kinvey Inc.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 */
package com.fischermanlabs.kinvey;

import com.fischermanlabs.utils.Constants;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

import android.app.Application;
import android.util.Log;

/**
 * Global application class.  Instantiates the KCS Client and sets global constants.
 *
 */
public class KinveyUserLogin extends Application {
    private Client service;

   //  Application Constants
    public static final String AUTHTOKEN_TYPE = "com.kinvey.myapplogin";
    public static final String ACCOUNT_TYPE = "com.kinvey.myapplogin";
    public static final String LOGIN_TYPE_KEY = "loginType";
    
    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }
   

    private void initialize() {
		// Enter your app credentials here
		service = new Client.Builder(this).build();
		
		service.ping(new KinveyPingCallback() {
			
			@Override
			public void onSuccess(Boolean arg0) {
				// TODO Auto-generated method stub
				 Log.e(Constants.TAG, "Kinvey Ping Success" + arg0);
			}
			
			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				 Log.e(Constants.TAG, "Kinvey Ping Failed" + arg0);
			}
		});
    }

    public Client getKinveyService() {
        return service;
    }
    
    
}
