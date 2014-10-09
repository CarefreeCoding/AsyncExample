package async.example.mvc.view.main;

import android.widget.Button;
import android.widget.TextView;
import async.example.mvc.controller.main.MainController;
import async.example.mvc.model.main.MainModel;
import async.example.mvc.view.View;
import mississauga.async.R;

public class MainView extends View<MainController, MainModel>
{
	private Button   btnCount;
	private TextView label;

	public MainView(MainController controller, MainModel model)
	{
		super(controller, model);
	}

	@Override
	public void setVisible(int visibility)
	{
		btnCount.setVisibility(visibility);
		label.setVisibility(visibility);
	}

	@Override
	protected void loadComponents()
	{
		btnCount = (Button) controller
				.findViewById(R.id.count_button);
		label = (TextView) controller
				.findViewById(R.id.label);
	}

	@Override
	protected void assignListeners()
	{
		btnCount.setOnClickListener(new android.view.View.OnClickListener()
		{
			@Override
			public void onClick(android.view.View view)
			{
				controller.count();
			}
		});
	}

	@Override
	public void registerModel(MainModel model)
	{
	}

	@Override
	public void refresh()
	{
	}

	public void showCountTime(String time)
	{
		label.setText(time);
	}
}
