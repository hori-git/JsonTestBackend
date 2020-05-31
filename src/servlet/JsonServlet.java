package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.JsonBean;
import dao.DAOManager;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Javaオブジェクトに値をセット
        JsonBean jsonBean = new JsonBean();


        //String str = request.getParameter("id");
        String str = "2";

        int requestId = Integer.parseInt(str);

        DAOManager dao = new DAOManager();

        String name = dao.searchEmployee(requestId);
        System.out.println("name"+name);
        jsonBean.setId(str);
        jsonBean.setName(name);
        ObjectMapper mapper = new ObjectMapper();
        try {
            //JavaオブジェクトからJSONに変換
            String testJson = mapper.writeValueAsString(jsonBean);
            System.out.println(testJson);
            //JSONの出力
            response.getWriter().write(testJson);

            System.out.println(testJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Javaオブジェクトに値をセット
        JsonBean jsonBean = new JsonBean();


        String str = request.getParameter("id");
//        String str = "1";

        int requestId = Integer.parseInt(str);

        DAOManager dao = new DAOManager();

        String name = dao.searchEmployee(requestId);
        System.out.println("name"+name);
        jsonBean.setId(str);
        jsonBean.setName(name);
        ObjectMapper mapper = new ObjectMapper();
        try {
            //JavaオブジェクトからJSONに変換
            String testJson = mapper.writeValueAsString(jsonBean);
            System.out.println(testJson);
            //JSONの出力
            response.getWriter().write(testJson);

            System.out.println(testJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
	}

}
