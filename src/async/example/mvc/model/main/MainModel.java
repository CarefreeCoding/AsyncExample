package async.example.mvc.model.main;

import async.example.mvc.controller.main.MainController;
import async.example.mvc.model.Model;

public class MainModel extends Model<MainController>
{
	public MainModel(MainController controller)
	{
		super(controller);
	}
}
