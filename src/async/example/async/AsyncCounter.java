package async.example.async;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import async.example.mvc.controller.main.MainController;

public class AsyncCounter extends AsyncTask<Long, Long, Long>
{
	private static final int COUNT = 1000000;

	private ProgressDialog progressDialog;

	private MainController controller;

	public AsyncCounter(MainController controller)
	{
		this.controller = controller;
	}

	@Override
	protected void onPreExecute()
	{
		progressDialog = new ProgressDialog(controller);
		progressDialog.setIndeterminate(false);
		progressDialog.setCancelable(false);
		progressDialog.setTitle("Counting");
		progressDialog.setMessage("Counting numbers ...");
		progressDialog.setMax(COUNT);
		progressDialog.show();
	}

	@Override
	protected void onProgressUpdate(Long... progress)
	{
		progressDialog.setProgress(Integer.valueOf(progress[0].toString()));
	}

	@Override
	protected Long doInBackground(Long... voids)
	{
		long time = System.currentTimeMillis();
		for (long i = 0; i < COUNT; i++)
		{
			onProgressUpdate(i);
		}
		return System.currentTimeMillis() - time;
	}

	@Override
	protected void onPostExecute(Long result)
	{
		super.onPostExecute(result);
		controller.setCount(result.toString());
		progressDialog.dismiss();
	}
}
