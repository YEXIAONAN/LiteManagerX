@Controller
@RequestMapping("/personal")
public class PersonalController {

    @GetMapping
    public String personal(Model model,
                           @RequestParam(defaultValue = "1") int page,
                           @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);                     // 用户信息
        Page<Log> logPage = logService.getUserLogs(user.getId(), page);
        model.addAttribute("records", logPage.getContent());  // 操作记录
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", logPage.getTotalPages());
        return "personal";   // 对应 templates/personal.html
    }

    @PostMapping("/updatePwd")
    @ResponseBody
    public Map<String,Boolean> updatePwd(@RequestParam String oldPwd,
                                         @RequestParam String newPwd,
                                         @AuthenticationPrincipal User user) {
        boolean ok = userService.updatePassword(user, oldPwd, newPwd);
        return Map.of("ok", ok);
    }

    @PostMapping("/upload/avatar")
    @ResponseBody
    public Map<String,Object> uploadAvatar(@RequestParam MultipartFile avatar,
                                           @AuthenticationPrincipal User user) throws IOException {
        String url = storageService.save(avatar);
        userService.updateAvatar(user, url);
        return Map.of("ok", true, "url", url);
    }
}
public record UserVo(Long id, String name, String email, String avatar, LocalDateTime createdAt) {}
@GetMapping("/main")
public String main(Model model, @AuthenticationPrincipal User user) {
    UserVo vo = new UserVo(user.getId(), user.getName(), user.getEmail(), user.getAvatar(), user.getCreatedAt());
    model.addAttribute("user", vo);
    model.addAttribute("records", logService.getUserLogs(user.getId(), page));
    return "main_dashboard";
}