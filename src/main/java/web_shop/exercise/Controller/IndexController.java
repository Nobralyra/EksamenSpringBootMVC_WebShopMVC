package web_shop.exercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Service.ProductService;

@Controller
public class IndexController
{
    @Autowired
    ProductService productService;

    @GetMapping({"", "/"})
    public String indexPage(Model model)
    {
        //add/read all products to model with from productService
        model.addAttribute("products", productService.readAll());
        return "/index";
    }

    @GetMapping("/create")
    public String create(Product product, Model model)
    {
        model.addAttribute("products", product);
        return "/create";
    }

    /**
     * @ModelAttribute binds form Product to model Product
     * @param product
     * @return String
     */
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product)
    {
        productService.create(product);
        return "redirect:/";
    }

    /**
     * use PathVariable to fetch id from list
     * @param id
     * @param model
     * @return String
     */
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model
        model.addAttribute("products", productService.read(id));
        return "/update";
    }

    //update product
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product)
    {
        productService.update(product);
        return "redirect:/";
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model)
    {
        //Should return the boolean value and send it to index
        try
        {
            model.addAttribute("test", productService.delete(id));
            //Can not get this to index.html because redirect, and I want the list to be displayed after delete
            model.addAttribute("status", "Element " + id + " slettet");
        }
        catch (Exception e)
        {
            //Can not use redirect because I then loose the message
            model.addAttribute("status", "Element " + id + " kunne ikke slettes!");
            return "/index";
        }
        return "redirect:/";
    }
}

