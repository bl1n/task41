package team.lf.task41;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.squareup.picasso.Picasso;

public class AvatarView extends ConstraintLayout {

    private TextView mName;
    private View mStatus;
    private ImageView mPhoto;

    public AvatarView(Context context) {
        this(context, null);
    }

    public AvatarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.avatar_view, this);
        mName = findViewById(R.id.name);
        mStatus = findViewById(R.id.status);
        mPhoto = findViewById(R.id.photo);

        TypedArray mainTypedArray = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.AvatarView, 0, R.style.AppTheme);
        String nameText = mainTypedArray.getString(R.styleable.AvatarView_name);
        setName(nameText);

        int imageResource = mainTypedArray.getResourceId(R.styleable.AvatarView_photo, R.drawable.ic_man);
        setPhoto(imageResource);

        Boolean status = mainTypedArray.getBoolean(R.styleable.AvatarView_isOnline, false);
        setStatus(status);

        mainTypedArray.recycle();
    }

    public void setName(CharSequence name) {
        if (!TextUtils.isEmpty(name))
            mName.setText(name);
        else mName.setText("Дефаулт Дефаултов");
    }

    public void setPhoto(int imageResource) {
        if (imageResource != 0) {
            mPhoto.setImageResource(imageResource);
        } else {
            mPhoto.setImageResource(R.drawable.ic_man);
        }
    }

    public void setStatus(Boolean isOnline) {
        mStatus.setBackgroundColor(isOnline ?
                getResources().getColor(R.color.colorOnline)
                : getResources().getColor(R.color.colorOffline));
    }
}
