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
        model.put("endageredAnimals",EndangeredAnimal.allEndangeredAnimals());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/endangered", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        String species = request.queryParams("endangered");
        Integer ageValue = Integer.parseInt(request.queryParams("age"));
        Integer healthValue = Integer.parseInt(request.queryParams("health"));
        String ageOutcome = "";
        String healthOutcome = "";
        if(ageValue==1){
          ageOutcome = EndangeredAnimal.NEW_ANIMAL;
        }else if(ageValue==2){
          ageOutcome = EndangeredAnimal.YOUNG_ANIMAL;
        }else{
          ageOutcome = EndangeredAnimal.OLDER_ANIMAL;
        }
        if(healthValue==1){
          healthOutcome = EndangeredAnimal.POOR_HEALTH_LEVEL;
        }else if(healthValue==2){
          healthOutcome = EndangeredAnimal.AVERAGE_HEALTH_LEVEL;
        }else{
          healthOutcome = EndangeredAnimal.GOOD_HEALTH_LEVEL;
        }
        EndangeredAnimal theAnimal = new EndangeredAnimal(species,healthOutcome,ageOutcome);
        try{
          theAnimal.save();
        }catch (UnsupportedOperationException exception){ }
        model.put("animals",Animal.all());
        model.put("endageredAnimals",EndangeredAnimal.allEndangeredAnimals());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/animal", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Animal newAnimal = new Animal(request.queryParams("animal"));
        try{
          newAnimal.save();
        }catch(UnsupportedOperationException exception){ }
        model.put("animals",Animal.all());
        model.put("endageredAnimals",EndangeredAnimal.all());
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

//Safe Animal form
      // get("/animal/:id", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
      //   model.put("template", "templates/index.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());

      // post("/", (request, response) -> {
      //   Map<String, Object> model = new HashMap<String, Object>();
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
