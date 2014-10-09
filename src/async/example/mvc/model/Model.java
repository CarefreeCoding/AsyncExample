package async.example.mvc.model;

import async.example.mvc.controller.Controller;

public abstract class Model<C extends Controller>
{
	protected C controller;

	public Model(C controller)
	{
		this.controller = controller;
	}
}
