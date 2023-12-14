import express from "express";
import {
    getKacamatas,
    getKacamataById,
    saveKacamata,
    updateKacamata,
    deleteKacamata
} from "../controllers/KacamataController.js";

const router = express.Router();

router.get('/kacamatas',getKacamatas);
router.get('/kacamatas/:id',getKacamataById);
router.post('/kacamatas',saveKacamata);
router.patch('/kacamatas/:id',updateKacamata);
router.delete('/kacamatas/:id',deleteKacamata);

export default router;

//http://localhost:5000/kacamatas/