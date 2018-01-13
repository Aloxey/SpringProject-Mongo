package com.p.SpringProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo", method = {RequestMethod.GET, RequestMethod.POST}) // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;


    //  Creates a new User
    //  Returns new users generated id
    @GetMapping(path = "/create")
    public @ResponseBody
    Integer addNewUser(@RequestParam String name, @RequestParam String address
            , @RequestParam String phone) throws Exception {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        if(address == null || address.isEmpty() || phone == null || phone.isEmpty() ||
            name == null || name.isEmpty() ) throw new IllegalArgumentException();

        User n = new User();
        n.setName(name);
        n.setAddress(address);
        n.setPhone(phone);

        n.setId();

        userRepository.save(n);
        return n.getId();
    }


    //  Returns all users
    @GetMapping(path = "/read-all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }


    //  Return user by it's id
    @GetMapping(path = "/get/{id}")
    public @ResponseBody
    User getUser(@PathVariable Integer id) {
        return userRepository.findById(id);
    }


    //  Select user by id and update one or more of it's fields
    @PostMapping("/update/{id}")
    @Transactional
    public @ResponseBody
    String editUser(@PathVariable Integer id/*@RequestParam Integer id*/, @RequestParam(required = false) String name,
                    @RequestParam(required = false) String address, @RequestParam(required = false) String phone) throws Exception {
        User n = new User();

        User user = userRepository.findById(id);
        if (name!=null) user.setName(name);
        if (address!=null) user.setAddress(address);
        if (phone!= null) user.setPhone(phone);

        userRepository.save(user);

        return "Done\n";
    }


    //  Delete user by id
    @DeleteMapping(path = "/delete/{id}")
    @Transactional
    public @ResponseBody
    String deleteUser(@PathVariable Integer id) {

        /*if (!userRepository.exists(id.longValue())){
            throw new IllegalArgumentException();
        }*/

        userRepository.deleteById(id);

        return "Done";
    }


    //  Deletes all users
    @DeleteMapping(path = "/delete-all")
    @Transactional
    public @ResponseBody
    String deleteUser() {

        userRepository.deleteAll();

        return "Done";
    }
}