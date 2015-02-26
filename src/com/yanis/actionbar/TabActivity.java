package com.yanis.actionbar;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.view.MenuItem;

public class TabActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab);

		initView();
	}

	private void initView() {
		// 提示getActionBar方法一定在setContentView后面
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// 添加Tab选项
		Tab tab = actionBar
				.newTab()
				.setText("澳门风云2")
				.setTabListener(
						new TabListener<Fragment1>(this, "film1",
								Fragment1.class));
		actionBar.addTab(tab);

		tab = actionBar
				.newTab()
				.setText("五十度灰")
				.setTabListener(
						new TabListener<Fragment2>(this, "film2",
								Fragment2.class));
		actionBar.addTab(tab);
		tab = actionBar
				.newTab()
				.setText("爸爸去哪儿2")
				.setTabListener(
						new TabListener<Fragment3>(this, "film3",
								Fragment3.class));
		actionBar.addTab(tab);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent upIntent = NavUtils.getParentActivityIntent(this);
			if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
				TaskStackBuilder.create(this)
						.addNextIntentWithParentStack(upIntent)
						.startActivities();
			} else {
				upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				NavUtils.navigateUpTo(this, upIntent);
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
