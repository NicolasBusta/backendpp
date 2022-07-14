package services.academicservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.academicservice.entity.Type;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {

    private List<String> typeDescription;
    private List<Type> typeList;
    private Type type;

    @GetMapping("/career")
    public List<Type> fetchAllCareerTypes() {
        typeDescription = new ArrayList<>();
        typeList = new ArrayList<>();

        this.typeDescription.add("Profesional");
        this.typeDescription.add("Técnico de Nivel Superior");
        this.typeDescription.add("Programa de Continuidad de Estudio");

        for (String description : this.typeDescription) {
            type = new Type();
            this.type.setDescription(description);
            typeList.add(this.type);
        }

        return typeList;
    }

    @GetMapping("/degree")
    public List<Type> fetchDegreeTypes() {
        typeDescription = new ArrayList<>();
        typeList = new ArrayList<>();

        this.typeDescription.add("Final");
        this.typeDescription.add("Intermedio");

        for (String description : this.typeDescription) {
            type = new Type();
            this.type.setDescription(description);
            typeList.add(this.type);
        }
        return typeList;
    }

    @GetMapping("/subject")
    public List<Type> fetchSubjectTypes() {
        typeDescription = new ArrayList<>();
        typeList = new ArrayList<>();

        this.typeDescription.add("Bimestral");
        this.typeDescription.add("Práctica");
        this.typeDescription.add("Seminario");
        this.typeDescription.add("Examen");

        for (String description : this.typeDescription) {
            type = new Type();
            this.type.setDescription(description);
            typeList.add(this.type);
        }
        return typeList;
    }

    @GetMapping("/modality")
    public List<Type> fetchAllModalityTypes() {
        typeDescription = new ArrayList<>();
        typeList = new ArrayList<>();

        this.typeDescription.add("Presencial");
        this.typeDescription.add("Semipresencial");
        this.typeDescription.add("Online Plus");

        for (String description : this.typeDescription) {
            type = new Type();
            this.type.setDescription(description);
            typeList.add(this.type);
        }

        return typeList;
    }

    @GetMapping("/lms")
    public List<Type> fetchAllLMSTypes() {
        typeDescription = new ArrayList<>();
        typeList = new ArrayList<>();

        this.typeDescription.add("Canvas");
        this.typeDescription.add("EduSoft");

        for (String description : this.typeDescription) {
            type = new Type();
            this.type.setDescription(description);
            typeList.add(this.type);
        }

        return typeList;
    }

    @GetMapping("/exam")
    public List<Type> fetchAllExamTypes() {
        typeDescription = new ArrayList<>();
        typeList = new ArrayList<>();

        this.typeDescription.add("Normal (22 preguntas)");
        this.typeDescription.add("Complejo (9 preguntas)");
        this.typeDescription.add("Sin Examen");
        this.typeDescription.add("Sin Examen (Nota 5)");
        this.typeDescription.add("Normal (30 preguntas)");

        for (String description : this.typeDescription) {
            type = new Type();
            this.type.setDescription(description);
            typeList.add(this.type);
        }

        return typeList;
    }

}
