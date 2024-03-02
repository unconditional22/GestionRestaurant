package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width initial-scale=1.0\">\n");
      out.write("    <title>Gestion Restaurant | Login</title>\n");
      out.write("    <!-- GLOBAL MAINLY STYLES-->\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/bootstrap/dist/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/font-awesome/css/font-awesome.min.css\" rel=\"stylesheet\" />\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/themify-icons/css/themify-icons.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- THEME STYLES-->\n");
      out.write("    <link href=\"assets/css/main.css\" rel=\"stylesheet\" />\n");
      out.write("    <!-- PAGE LEVEL STYLES-->\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/css/pages/auth-light.css\" rel=\"stylesheet\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"bg-silver-300\">\n");
      out.write("    <div class=\"content\">\n");
      out.write("        <div class=\"brand\">\n");
      out.write("            <a class=\"link\" href=\"index.html\">Gestion Restaurant</a>\n");
      out.write("        </div>\n");
      out.write("        <form id=\"login-form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/EmployeeServlet\" method=\"post\">\n");
      out.write("            <h2 class=\"login-title\">Authentification</h2>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"input-group-icon right\">\n");
      out.write("                    <div class=\"input-icon\"><i class=\"fa fa-envelope\"></i></div>\n");
      out.write("                    <input class=\"form-control\" type=\"text\" name=\"usernameEmp\" placeholder=\"Username\" autocomplete=\"off\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <div class=\"input-group-icon right\">\n");
      out.write("                    <div class=\"input-icon\"><i class=\"fa fa-lock font-16\"></i></div>\n");
      out.write("                    <input class=\"form-control\" type=\"password\" name=\"passwordEmp\" placeholder=\"Mot de passe\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("<!--            <div class=\"form-group d-flex justify-content-between\">\n");
      out.write("                <label class=\"ui-checkbox ui-checkbox-info\">\n");
      out.write("                    <input type=\"checkbox\">\n");
      out.write("                    <span class=\"input-span\"></span>Remember me</label>\n");
      out.write("                <a href=\"forgot_password.html\">Forgot password?</a>\n");
      out.write("            </div>-->\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <button class=\"btn btn-info btn-block\" type=\"connexion\">Connexion</button>\n");
      out.write("            </div>\n");
      out.write("<!--            <div class=\"social-auth-hr\">\n");
      out.write("                <span>Or login with</span>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center social-auth m-b-20\">\n");
      out.write("                <a class=\"btn btn-social-icon btn-twitter m-r-5\" href=\"javascript:;\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                <a class=\"btn btn-social-icon btn-facebook m-r-5\" href=\"javascript:;\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                <a class=\"btn btn-social-icon btn-google m-r-5\" href=\"javascript:;\"><i class=\"fa fa-google-plus\"></i></a>\n");
      out.write("                <a class=\"btn btn-social-icon btn-linkedin m-r-5\" href=\"javascript:;\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                <a class=\"btn btn-social-icon btn-vk\" href=\"javascript:;\"><i class=\"fa fa-vk\"></i></a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">Not a member?\n");
      out.write("                <a class=\"color-blue\" href=\"register.html\">Create accaunt</a>\n");
      out.write("            </div>-->\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("    <!-- BEGIN PAGA BACKDROPS-->\n");
      out.write("    <div class=\"sidenav-backdrop backdrop\"></div>\n");
      out.write("    <div class=\"preloader-backdrop\">\n");
      out.write("        <div class=\"page-preloader\">Loading</div>\n");
      out.write("    </div>\n");
      out.write("    <!-- END PAGA BACKDROPS-->\n");
      out.write("    <!-- CORE PLUGINS -->\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/jquery/dist/jquery.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/popper.js/dist/umd/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/bootstrap/dist/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- PAGE LEVEL PLUGINS -->\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/vendors/jquery-validation/dist/jquery.validate.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- CORE SCRIPTS-->\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/theme/dist/assets/js/app.js\" type=\"text/javascript\"></script>\n");
      out.write("    <!-- PAGE LEVEL SCRIPTS-->\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        $(function() {\n");
      out.write("            $('#login-form').validate({\n");
      out.write("                errorClass: \"help-block\",\n");
      out.write("                rules: {\n");
      out.write("                    username: {\n");
      out.write("                        required: true,\n");
      out.write("                        username: true\n");
      out.write("                    },\n");
      out.write("                    password: {\n");
      out.write("                        required: true\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                highlight: function(e) {\n");
      out.write("                    $(e).closest(\".form-group\").addClass(\"has-error\")\n");
      out.write("                },\n");
      out.write("                unhighlight: function(e) {\n");
      out.write("                    $(e).closest(\".form-group\").removeClass(\"has-error\")\n");
      out.write("                },\n");
      out.write("            });\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
