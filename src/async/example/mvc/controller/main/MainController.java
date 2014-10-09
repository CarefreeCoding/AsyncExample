package async.example.mvc.controller.main;

import android.view.Menu;
import android.view.MenuItem;
import async.example.async.AsyncCounter;
import async.example.mvc.controller.Controller;
import async.example.mvc.model.main.MainModel;
import async.example.mvc.view.main.MainView;
import mississauga.async.R;

public class MainController extends Controller<MainView, MainModel>
{
	@Override
	public void init()
	{
		setContentView(R.layout.main);

		view = new MainView(this, model);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		return false;
	}

	public void count()
	{
		AsyncCounter counter = new AsyncCounter(this);
		counter.execute(3l);
	}

	public void setCount(String message)
	{
		view.showCountTime(message);
	}
}
