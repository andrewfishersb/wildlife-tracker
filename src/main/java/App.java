import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;


public class App{
    public static void main(String[] args) {
      staticFileLocation("/public");
      String layout = "templates/layout.vtl";

//initial view
      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("animals",Animal.all());
        model.put("endageredAnimals",EndangeredAnimal.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/endangered", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        String species = request.queryParams("endangered");
        Integer healthValue = request.queryParams("health")

        try{
          anEndangeredAnimal.save();
        }catch (UnsupportedOperationException exception)
      { }

        String species
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

//form submit to first page
      // post("/endangered", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   // try{
      //   EndangeredAnimal
      //   // }catch
      //
      //   model.put("template", "templates/endangeredform.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());














//Templates for get and post
      // get("/", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   model.put("template", "templates/index.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());
      //
      // post("/", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());
}
}
