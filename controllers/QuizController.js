import tf, { loadLayersModel } from "@tensorflow/tfjs";
import { INTEGER } from "sequelize";

const modelPath =
  "";
let model;
async function loadModel() {
  try {
    model = await loadLayersModel(modelPath);
    console.log("Model loaded successfully");
    // Use the loaded model for predictions or other tasks
  } catch (error) {
    console.error("Error loading the model:", error.message);
  }
}
loadModel();
class QuizController {
  static quizPrediction = async (req, res) => {
    try {
      const inputData = req.body.inputData.map(Number);
      const inputTensor = tf.tensor2d(inputData, [1, 10]);
      const result = model.predict(inputTensor);
      const outputData = result.dataSync(INTEGER);        
      res.json({ success: true, outputData });
    } catch (error) {
      console.error("Error during prediction:", error);
      res.status(500).json({ success: false, error: error.message });
    }
  };
}
export default QuizController;