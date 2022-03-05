// Generated by view binder compiler. Do not edit!
package com.rossven.healty.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rossven.healty.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView buyukTans;

  @NonNull
  public final ImageButton historyButton;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView kucukTans;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull TextView buyukTans,
      @NonNull ImageButton historyButton, @NonNull ImageView imageView,
      @NonNull ImageView imageView2, @NonNull TextView kucukTans, @NonNull TextView textView,
      @NonNull TextView textView3, @NonNull TextView textView4) {
    this.rootView = rootView;
    this.buyukTans = buyukTans;
    this.historyButton = historyButton;
    this.imageView = imageView;
    this.imageView2 = imageView2;
    this.kucukTans = kucukTans;
    this.textView = textView;
    this.textView3 = textView3;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buyuk_tans;
      TextView buyukTans = ViewBindings.findChildViewById(rootView, id);
      if (buyukTans == null) {
        break missingId;
      }

      id = R.id.historyButton;
      ImageButton historyButton = ViewBindings.findChildViewById(rootView, id);
      if (historyButton == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.kucuk_tans;
      TextView kucukTans = ViewBindings.findChildViewById(rootView, id);
      if (kucukTans == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, buyukTans, historyButton,
          imageView, imageView2, kucukTans, textView, textView3, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
