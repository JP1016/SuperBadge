package com.devzstudio.superbadge;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SuperBadge extends RelativeLayout {

    private Context mContext;
    private OnBadgeClickListener mListener;
    private TextView mPrimaryText;
    private TextView mSecondaryText;
    private TextView mTertiaryText;
    private ImageView badgeImage;
    private RelativeLayout rootLayout;
    private String image;

    public SuperBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        LayoutInflater mInflater = LayoutInflater.from(context);
        View mView = mInflater.inflate(R.layout.badge_inner, this, true);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SuperBadge);
        String primary = a.getString(R.styleable.SuperBadge_sb_primaryText);
        String secondary = a.getString(R.styleable.SuperBadge_sb_secondaryText);
        String tertiary = a.getString(R.styleable.SuperBadge_sb_tertiaryText);
        image = a.getString(R.styleable.SuperBadge_sb_image);

        int primaryColor = a.getColor(R.styleable.SuperBadge_sb_primaryTextColor, getResources().getColor(R.color.def));
        int secondaryColor = a.getColor(R.styleable.SuperBadge_sb_secondaryTextColor, getResources().getColor(R.color.def));
        int tertiaryColor = a.getColor(R.styleable.SuperBadge_sb_tertiaryTextColor, getResources().getColor(R.color.def));

        a.recycle();


        badgeImage = mView.findViewById(R.id.badge_image);

        mPrimaryText = mView.findViewById(R.id.primaryText);
        mSecondaryText = mView.findViewById(R.id.secondaryText);
        mTertiaryText = mView.findViewById(R.id.tertiaryText);
        rootLayout = mView.findViewById(R.id.rootLayout);

        mPrimaryText.setText(primary);
        mSecondaryText.setText(secondary);
        mTertiaryText.setText(tertiary);

        mPrimaryText.setTextColor(primaryColor);
        mSecondaryText.setTextColor(secondaryColor);
        mTertiaryText.setTextColor(tertiaryColor);

        loadImage(image);

        rootLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mListener.onBadgeClick();
                } catch (Exception ex) {
                }
            }
        });

    }

    public void loadImage(String imageUrl) {
        try {
            Picasso.get().load(imageUrl).into(badgeImage);
        } catch (Exception ex) {
        }
    }

    public void setImage(String imageUrl) {
        loadImage(imageUrl);
    }

    public void setPrimaryText(String primaryText) {
        this.mPrimaryText.setText(primaryText);
    }

    public void setSecondaryText(String secondaryText) {
        this.mSecondaryText.setText(secondaryText);
    }

    public void setTertiaryText(String tertiaryText) {
        this.mTertiaryText.setText(tertiaryText);
    }

    public void setOnBageClickListener(OnBadgeClickListener listener) {
        mListener = listener;
    }

    public interface OnBadgeClickListener {

        void onBadgeClick();

    }
}
