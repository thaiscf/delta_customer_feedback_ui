package delta.co.nz.controller;


import delta.co.nz.config.EmailConfig;
import delta.co.nz.schema.Feedback;
import delta.co.nz.service.FeedbackService;
import delta.co.nz.service.ProductService;
import delta.co.nz.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    ProductService productService;

    @Autowired
    EmailService emailService;

    @Autowired
    EmailConfig emailConfig;

    @RequestMapping(value="/feedback", method = RequestMethod.GET)
    public ModelAndView feedback(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("feedback", new Feedback());
        modelAndView.addObject("productList", productService.getProducts());
        modelAndView.setViewName("feedback");

        return modelAndView;
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ModelAndView createFeedback(@Valid Feedback feedback, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();

        if (!bindingResult.hasErrors()) {

            try {

                feedback.setSentTo(emailConfig.emailRecipient);
                emailService.send(emailConfig.emailSubject, feedback.toString(), feedback.getCustomer().getEmail(), feedback.getSentTo());
                feedbackService.sendFeedback(feedback);

                modelAndView.addObject("successMessage", "Thanks for your feedback!");
                modelAndView.addObject("feedback", new Feedback());
                modelAndView.addObject("productList", productService.getProducts());

            } catch (Exception e) {
                //TODO: log errors
            }
        }

        modelAndView.setViewName("feedback");
        return modelAndView;
    }
}
