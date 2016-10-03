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
      get("/animal/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Animal curAnimal = Animal.find(Integer.parseInt(request.params("id")));
        model.put("animal",curAnimal);
        model.put("sightings",curAnimal.getSightings());
        model.put("template", "templates/animal.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/animal/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Animal curAnimal = Animal.find(Integer.parseInt(request.params("id")));
        String name = request.queryParams("name");
        String location = request.queryParams("location");
        Sighting theSighting = new Sighting(name,location,curAnimal.getId());
        theSighting.save();
        String url = String.format("/animal/%d", curAnimal.getId());
        response.redirect(url);
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/endangered/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        EndangeredAnimal curEndangered = EndangeredAnimal.findEndangeredAnimal(Integer.parseInt(request.params("id")));
        model.put("endangered",curEndangered);
        model.put("sightings",curEndangered.getSightings());
        model.put("template", "templates/endangered.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/endangered/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        EndangeredAnimal curEndangered = EndangeredAnimal.findEndangeredAnimal(Integer.parseInt(request.params("id")));
        String name = request.queryParams("name");
        String location = request.queryParams("location");
        Sighting theSighting = new Sighting(name,location,curEndangered.getId());
        theSighting.save();
        String url = String.format("/endangered/%d", curEndangered.getId());
        response.redirect(url);
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/animal/:id/deleted", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Animal.find(Integer.parseInt(request.params("id"))).delete();
        response.redirect("/");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/endangered/:id/deleted", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        EndangeredAnimal.findEndangeredAnimal(Integer.parseInt(request.params("id"))).delete();
        response.redirect("/");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    }
}
