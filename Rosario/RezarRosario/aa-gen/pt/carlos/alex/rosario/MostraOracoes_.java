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

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.googlecode.androidannotations.api.BackgroundExecutor;
import pt.carlos.alex.rosario.R.layout;

public final class MostraOracoes_
    extends MostraOracoes
{

    private View contentView_;
    private Handler handler_ = new Handler();

    private void init_(Bundle savedInstanceState) {
        beforeCreate();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    private void afterSetContentView_() {
        mPager = ((ViewPager) findViewById(pt.carlos.alex.rosario.R.id.pager));
        mIndicator = ((ContasRosario) findViewById(pt.carlos.alex.rosario.R.id.indicator));
        afterCreate();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.oracoes_page_layout, container, false);
        }
        afterSetContentView_();
        return contentView_;
    }

    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    public static MostraOracoes_.FragmentBuilder_ builder() {
        return new MostraOracoes_.FragmentBuilder_();
    }

    @Override
    public void geraPageView() {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                try {
                    MostraOracoes_.super.geraPageView();
                } catch (RuntimeException e) {
                    Log.e("MostraOracoes_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    @Override
    public void initDezena() {
        BackgroundExecutor.execute(new Runnable() {


            @Override
            public void run() {
                try {
                    MostraOracoes_.super.initDezena();
                } catch (RuntimeException e) {
                    Log.e("MostraOracoes_", "A runtime exception was thrown while executing code in a runnable", e);
                }
            }

        }
        );
    }

    public static class FragmentBuilder_ {

        private Bundle args_;

        private FragmentBuilder_() {
            args_ = new Bundle();
        }

        public MostraOracoes build() {
            MostraOracoes_ fragment_ = new MostraOracoes_();
            fragment_.setArguments(args_);
            return fragment_;
        }

    }

}
