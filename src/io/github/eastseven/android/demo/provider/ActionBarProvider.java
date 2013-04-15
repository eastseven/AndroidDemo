package io.github.eastseven.android.demo.provider;

import io.github.eastseven.android.demo.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class ActionBarProvider extends ActionProvider {

	private ContextWrapper contextWrapper;

	PopupMenu popupMenu;

	public ActionBarProvider(Context context) {
		super(context);
		this.contextWrapper = (ContextWrapper) context;
	}

	@Override
	public View onCreateActionView() {
		LayoutInflater layoutInflater = LayoutInflater.from(contextWrapper);
		View view = layoutInflater.inflate(R.layout.action_bar_provider, null);
		ImageView popupView = (ImageView) view.findViewById(R.id.popup_view);
		popupView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showPopup(v);
			}
		});
		return view;
	}

	void showPopup(View view) {
		this.popupMenu = new PopupMenu(contextWrapper, view);
		this.popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				return false;
			}
		});
		
		MenuInflater inflater = this.popupMenu.getMenuInflater();
		inflater.inflate(R.menu.action_bar, this.popupMenu.getMenu());
		this.popupMenu.show();
	}
}
