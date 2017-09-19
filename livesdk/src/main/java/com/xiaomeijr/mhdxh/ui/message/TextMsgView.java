package com.xiaomeijr.mhdxh.ui.message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.xiaomeijr.mhdxh.R;
import com.xiaomeijr.mhdxh.controller.EmojiManager;
import com.xiaomeijr.mhdxh.ui.activity.PcVideoPlayActivity;
import com.xiaomeijr.mhdxh.ui.widget.myDialog;
import com.xiaomeijr.mhdxh.utils.Constant;

import java.util.HashMap;
import java.util.Map;

import io.rong.imlib.model.MessageContent;
import io.rong.imlib.model.UserInfo;
import io.rong.message.TextMessage;

public class TextMsgView extends BaseMsgView {

    private TextView username;
    private TextView msgText;
    private Context context;

    public TextMsgView(final Context context) {
        super(context);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.msg_text_view, this);
        username = (TextView) view.findViewById(R.id.username);
        msgText = (TextView) view.findViewById(R.id.msg_text);
        this.context =context;

    }

    @Override
    public void setContent(MessageContent msgContent) {
        final TextMessage msg = (TextMessage) msgContent;
        username.setText(msg.getUserInfo().getName() + ": ");
        msgText.setText(EmojiManager.parse(msg.getContent(), msgText.getTextSize()));

    }

    @Override
    public View getName() {
        return username;
    }
}