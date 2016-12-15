package com.obigo.obigoproject.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoadingListener;
import com.obigo.obigoproject.R;
import com.obigo.obigoproject.util.ConstantsUtil;
import com.obigo.obigoproject.vo.Message;

import java.util.List;

/**
 * Created by O BI HE ROCK on 2016-12-06
 * 김용준, 최현욱
 * message list 정리 - 아직 @+id 미구현
 * date type 정리
 * image loader 구현 필요
 */

public class MessageListAdapter extends ArrayAdapter<Message> {

    private Activity activity;
    private List<Message> messageList;
    private Message objBean;
    private int row;
    private DisplayImageOptions options;
    ImageLoader imageLoader;

    public MessageListAdapter(Activity activity, int resource, List<Message> messageList) {
        super(activity, resource, messageList);
        this.activity = activity;
        this.row = resource;
        this.messageList = messageList;

        options = new DisplayImageOptions.Builder()
                .showStubImage(R.drawable.profile)
                .showImageForEmptyUrl(R.drawable.profile).cacheInMemory()
                .cacheOnDisc().build();
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((messageList == null) || ((position + 1) > messageList.size()))
            return view;

        objBean = messageList.get(position);

        holder.tvTitle = (TextView) view.findViewById(R.id.tvtitle);
        holder.tvDesc = (TextView) view.findViewById(R.id.tvdesc);
        holder.tvDate = (TextView) view.findViewById(R.id.tvdate);
        holder.imgView = (ImageView) view.findViewById(R.id.image);
        holder.pbar = (ProgressBar) view.findViewById(R.id.pbar);

        if (holder.tvTitle != null && null != objBean.getTitle()
                && objBean.getTitle().trim().length() > 0) {
            holder.tvTitle.setText(Html.fromHtml(objBean.getTitle()));
        }
        if (holder.tvDesc != null && null != objBean.getContent()
                && objBean.getContent().trim().length() > 0) {
            holder.tvDesc.setText(Html.fromHtml(objBean.getContent()));
        }
        if (holder.tvDate != null && null != objBean.getSendDate()
                && objBean.getSendDate().trim().length() > 0) {
            holder.tvDate.setText(Html.fromHtml(objBean.getSendDate()));
        }
        if (holder.imgView != null) {
            if (null != objBean.getUploadFile()
                    && objBean.getUploadFile().trim().length() > 0) {
                final ProgressBar pbar = holder.pbar;

                imageLoader.init(ImageLoaderConfiguration
                        .createDefault(activity));
                imageLoader.displayImage(ConstantsUtil.SERVER_API_URL_REAL + ConstantsUtil.SERVER_VEHICLE_IMAGE_URL + "5530854478867_img_visual_car.png", holder.imgView,
                        options, new ImageLoadingListener() {
                            @Override
                            public void onLoadingComplete() {
                                pbar.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onLoadingFailed() {
                                pbar.setVisibility(View.INVISIBLE);
                            }

                            @Override
                            public void onLoadingStarted() {
                                pbar.setVisibility(View.VISIBLE);
                            }
                        });

            } else {
                holder.imgView.setImageResource(R.mipmap.ic_launcher);
            }
        }

        return view;
    }

    public class ViewHolder {

        public TextView tvTitle, tvDesc, tvDate;
        private ImageView imgView;
        private ProgressBar pbar;

    }

}
