package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class testmethods {
	public static void main(String[] args) throws Exception {
		UserModel model = new UserModel();
		List list = model.searchListMethod();
		
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			UserBean bean = (UserBean)it.next();
			System.out.print(bean.getNo());
			System.out.print(bean.getName());
			System.out.print(bean.getLoginId());
			System.out.print(bean.getPassword());
			System.out.print(bean.getConfirmPass());
			System.out.println(bean.getContact());
		}
	}
}
