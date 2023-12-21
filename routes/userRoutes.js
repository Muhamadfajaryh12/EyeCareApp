import express from "express";
const router = express.Router();
import UserController from "../controllers/userController.js";
import checkUserAuth from "../middlewares/auth-middleware.js";
import QuizController from "../controllers/QuizController.js";

router.use("/changepassword", checkUserAuth);
router.use("/loggeduser", checkUserAuth);

// end point
router.post("/register", UserController.userRegistration);
router.post("/login", UserController.userLogin);
router.get('/:id', UserController.getUserDetail);
router.post(
  "/send-reset-password-email",
  UserController.sendUserPasswordResetEmail
);
router.post("/reset-password/:id/:token", UserController.userPasswordReset);

router.post("/changepassword", UserController.changeUserPassword);
router.get("/loggeduser", UserController.loggedUser);
router.post("/quizcontroller", QuizController.quizPrediction);
export default router;