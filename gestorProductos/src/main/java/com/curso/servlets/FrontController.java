package com.curso.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController Se encarga de dirigir hacia las
 * demás acciones
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean recibido = (request.getParameter("opcion") != null) && (request.getParameter("id") != null);
		if (recibido) {
			String opcion = request.getParameter("opcion").toLowerCase();
			// Recuperamos el id del producto
			Long id = Long.valueOf(request.getParameter("id"));
			switch (opcion) {

			case "modificar":
				// Llammaos a modificar.FOrm para modificar
				request.setAttribute("idProducto", id);
				request.getRequestDispatcher("modificarForm.jsp").forward(request, response);

				break;
			case "eliminar":
				// Llamamos a otro servlet para eliminar
				request.setAttribute("idProducto", id);
				request.getRequestDispatcher("EliminarFormServlet").forward(request, response);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
