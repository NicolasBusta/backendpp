package services.academicservice.utils;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.academicservice.errorHandler.GenericErrorResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponse(responseCode = "200", description = "Deleted successfully")
@ApiResponse(responseCode = "400", description = "Invalid data", content = {
        @Content(
                array = @ArraySchema(schema = @Schema(implementation = GenericErrorResponse.class)))
})
@ApiResponse(responseCode = "404", description = "Not found", content = {
        @Content(
                array = @ArraySchema(schema = @Schema(implementation = GenericErrorResponse.class)))
})
public @interface ApiDelete {

    @AliasFor(annotation = RequestMapping.class)
    String[] value() default {};

    @AliasFor(annotation = RequestMapping.class)
    String[] path() default {};

}
