/*
 * Copyright (c) 2013. Alexanndre Carlos.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations.
//


package pt.carlos.alex.rosario;

import android.app.Activity;
import android.content.Context;
import android.view.View;

public final class RosarioFatima_
    extends RosarioFatima
{

    private Context context_;
    private static RosarioFatima_ instance_;

    private RosarioFatima_(Context context) {
        context_ = context;
        init_();
    }

    public void afterSetContentView_() {
        if (!(context_ instanceof Activity)) {
            return ;
        }
    }

    /**
     * You should check that context is an activity before calling this method
     * 
     */
    public View findViewById(int id) {
        Activity activity_ = ((Activity) context_);
        return activity_.findViewById(id);
    }

    @SuppressWarnings("all")
    private void init_() {
        if (context_ instanceof Activity) {
            Activity activity = ((Activity) context_);
        }
        if (context_ instanceof Activity) {
            activity = ((Activity) context_);
        }
        afterCreate();
    }

    public static RosarioFatima_ getInstance_(Context context) {
        if (instance_ == null) {
            instance_ = new RosarioFatima_(context.getApplicationContext());
        }
        return instance_;
    }

    public void rebind(Context context) {
    }

}
