package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/doLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerId = request.getParameter("customerId");
		
		// Perform business logic. Return a bean as a result.
		// DB 를 해야하는데 아직 안배워서 해시맵으로 대체
		CustomerService service = new CustomerService();
		Customer customer = service.findCustomer(customerId);
		request.setAttribute("customer", customer);
		
		List<Customer> customerList = service.getAllCustomers();
		request.setAttribute("customers", customerList);
		
		String page; 
		if(customer == null)
			page = "/view/error.jsp";
		else
			page = "/view/success.jsp";
		
		// Dispatcher 란  parameter 로 온 정보를 다음페이지 까지 전달할 수 있도록 저장하는 역할
		// dispatcher.forward 를 사용시 다음페이지 까지 그대로 전달...... dispatecher.redirect 는 이전의 데이터를 사용못함
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
		
	}


}
