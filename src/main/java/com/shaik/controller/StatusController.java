package com.shaik.controller;

import com.shaik.model.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class StatusController {

    public static final int PAGE_LENGTH = 10;

    private List<Status> statuses;

    private void loadStatuses() {
        statuses = new ArrayList<>();
        statuses.add(new Status(1, "@user123", "John Smith", "Just enjoyed a delicious cup of coffee at my favorite cafe. ☕️ #CoffeeLover"));
        statuses.add(new Status(2, "@naturelover22", "Nature Lover", "Spent the weekend hiking in the mountains, surrounded by breathtaking views. 🌲🏞️ #Nature"));
        statuses.add(new Status(3, "@techgeek", "Tech Geek", "Exciting news in the tech world today! The new smartphone models are coming soon. 📱 #TechNews"));
        statuses.add(new Status(4, "@bookworm", "Bookworm", "Started reading a new book last night. Can't put it down! 📚 #BookRecommendation"));
        statuses.add(new Status(5, "@foodie", "Foodie", "Tried a new recipe for homemade pizza tonight. Turned out better than expected! 🍕 #Foodie"));
        statuses.add(new Status(6, "@traveler", "Wanderlust", "Dreaming of my next travel adventure. Where should I go next? ✈️ #TravelGoals"));
        statuses.add(new Status(7, "@musiclover", "Music Lover", "Listening to my favorite band's new album on repeat. Pure musical bliss! 🎶 #Music"));
        statuses.add(new Status(8, "@fitnessfanatic", "Fitness Fanatic", "Morning workout complete. Feeling strong and energized! 💪 #Fitness"));
        statuses.add(new Status(9, "@movielover", "Movie Buff", "Movie night with friends! Popcorn, cozy blankets, and a great film. 🍿🎬 #MovieNight"));
        statuses.add(new Status(10, "@gamer", "Gamer", "Just achieved a new high score in my favorite video game. Victory dance time! 🎮🕹️ #Gaming"));
        statuses.add(new Status(11, "@artenthusiast", "Art Enthusiast", "Visited an art gallery today and was inspired by the amazing artwork on display. 🎨 #Art"));
        statuses.add(new Status(12, "@petlover", "Pet Lover", "Spent the day at the park with my furry friend. Dogs make life better! 🐶❤️ #DogLove"));
        statuses.add(new Status(13, "@positivevibes", "Positive Vibes", "Sending positive vibes and smiles to everyone today. 😊✨ #Positivity"));
        statuses.add(new Status(14, "@fashionista", "Fashionista", "Fashion is my passion! Loving the latest trends and styles. 👗👠 #Fashion"));
        statuses.add(new Status(15, "@cookingenthusiast", "Cooking Enthusiast", "Experimented with a new dessert recipe. It's a sweet success! 🍰👩‍🍳 #Baking"));
        statuses.add(new Status(16, "@historybuff", "History Buff", "Delving into a historical documentary marathon today. Learning is fun! 📜📺 #History"));
        statuses.add(new Status(17, "@photographer", "Photographer", "Captured a stunning sunset photo by the beach. Nature's beauty never disappoints. 🌅📷 #Photography"));
        statuses.add(new Status(18, "@inspiration", "Inspiration Seeker", "Finding inspiration in the little things. Gratitude for life's blessings. 🙏✨ #Gratitude"));
        statuses.add(new Status(19, "@gardener", "Gardener", "Gardening therapy! Planting colorful flowers and watching them bloom. 🌸🌿 #Gardening"));
        statuses.add(new Status(20, "@comedylover", "Comedy Lover", "Laughter is the best medicine. Enjoying a comedy show tonight. 😂🤣 #Comedy"));
        statuses.add(new Status(21, "@codinggeek", "Coding Geek", "Solving complex coding problems is my idea of fun. #Programming"));
        statuses.add(new Status(22, "@yogaenthusiast", "Yoga Enthusiast", "Morning yoga session to start the day with peace and balance. 🧘‍♀️🌞 #Yoga"));
        statuses.add(new Status(23, "@volunteer", "Volunteer", "Spent the weekend volunteering at a local shelter. Small acts of kindness can make a big difference. ❤️ #Volunteer"));
        statuses.add(new Status(24, "@startupfounder", "Startup Founder", "Building the future one step at a time. The journey is the destination. 🚀 #Entrepreneur"));
        statuses.add(new Status(25, "@poetrylover", "Poetry Lover", "Penning down my thoughts in poetic verses. Expressing the heart's deepest emotions through words. 📝 #Poetry"));
        statuses.add(new Status(26, "@DIYenthusiast", "DIY Enthusiast", "Crafting and creating DIY projects bring so much joy. Today, it's a homemade candle! 🕯️ #DIY"));
        statuses.add(new Status(27, "@beachbum", "Beach Lover", "Salt in the air, sand in my hair. A perfect day at the beach! 🏖️ #BeachLife"));
        statuses.add(new Status(28, "@environmentalist", "Environmentalist", "Let's protect our planet. Reduce, reuse, recycle! 🌍🌱 #Environment"));
        statuses.add(new Status(29, "@bookclub", "Book Club Member", "Discussing the latest book club pick with friends. Bookworms unite! 📖 #BookClub"));
        statuses.add(new Status(30, "@coffeeaddict", "Coffee Addict", "Coffee is my love language. Cheers to a fresh brew! ☕️❤️ #Coffee"));
        statuses.add(new Status(31, "@wanderer", "Wanderer", "Exploring new places, meeting new people, and collecting memories along the way. 🌎✈️ #Travel"));
        statuses.add(new Status(32, "@healthyliving", "Healthy Living", "Eating clean and staying active for a healthier, happier life. 🥗🏋️‍♀️ #HealthyLiving"));
        statuses.add(new Status(33, "@moviecritic", "Movie Critic", "Just watched a thought-provoking film. The performances were outstanding! 🎥🍿 #FilmReview"));
        statuses.add(new Status(34, "@animalrights", "Animal Rights Advocate", "Every creature deserves love and respect. Let's protect our furry friends! 🐾❤️ #AnimalRights"));
        statuses.add(new Status(35, "@stargazer", "Stargazer", "Tonight's sky is a canvas of stars. Finding peace in the cosmos. 🌌✨ #Astronomy"));
        statuses.add(new Status(36, "@motivation", "Motivation", "Believe in yourself and your dreams. You're capable of amazing things. 💪🌟 #Motivation"));
        statuses.add(new Status(37, "@chefathome", "Chef at Home", "Cooking up a storm in my kitchen today. Who wants to join me for dinner? 🍽️🍷 #HomeCooking"));
    }

    @GetMapping(value = {"/" ,"/feed"})
    public String getFeed(Model model) {
        loadStatuses();
        model.addAttribute("statuses", statuses.subList(0, PAGE_LENGTH));
        model.addAttribute("nextStatuses", "/statuses?page=2");
        model.addAttribute("recordsLoaded", PAGE_LENGTH);
        System.out.println("in /feed");
        return "feed";
    }

    @GetMapping("/statuses")
    public String getStatuses(@RequestParam Integer page, Model model) throws InterruptedException {
        System.out.println("in /statuses");
        var to = page * PAGE_LENGTH;
        var from = to - PAGE_LENGTH;
        if (to > statuses.size()) {
            model.addAttribute("statuses", statuses.subList(from, statuses.size()));
            model.addAttribute("disableBtn", "true");
            model.addAttribute("recordsLoaded", from+(statuses.size()-from));
        } else {
            model.addAttribute("statuses", statuses.subList(from, to));
            model.addAttribute("nextStatuses", "/statuses?page=" + (page + 1));
            model.addAttribute("recordsLoaded", to);
        }
        return "statuses";
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteStatus(@PathVariable int userId, Model model) {
        System.out.println("delete status for id " + userId);
       Iterator<Status> iterator = statuses.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().id() == userId) {
                iterator.remove();
            }
        }
        return "empty";
    }

    @PostMapping("/searchFeed")
    public String search(String query,Model model) {
        System.out.println("query = "+query);
        if(query != null && !query.isEmpty()) {
            ArrayList<Status> matchedStatus = new ArrayList<>();
            String q= query.trim().toLowerCase();
            statuses.forEach(status -> {
                if (status.userHandle().toLowerCase().contains(q) ||
                        status.userDisplayName().toLowerCase().contains(q)) {
                    matchedStatus.add(status);
                }
            });
            model.addAttribute("statuses",matchedStatus);
           model.addAttribute("recordsLoaded", matchedStatus.size());
        }else if(statuses.size() > PAGE_LENGTH) {
            model.addAttribute("statuses", statuses.subList(0, PAGE_LENGTH));
            model.addAttribute("recordsLoaded", PAGE_LENGTH);
        } else{
            model.addAttribute("statuses", statuses);
            model.addAttribute("recordsLoaded", statuses.size());
        }
        model.addAttribute("nextStatuses", "/statuses?page=2");
        return "statuses";
    }

}