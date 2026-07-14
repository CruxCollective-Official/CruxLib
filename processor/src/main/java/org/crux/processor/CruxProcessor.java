package org.crux.processor;

import org.crux.annotations.Registry;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedAnnotationTypes("org.crux.annotations.Registry")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CruxProcessor extends AbstractProcessor {
    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv
    ) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Registry.class)) {
            processingEnv.getMessager().printMessage(
                    Diagnostic.Kind.NOTE,
                    "Found Registry: " + element
            );
        }

        return true;
    }
}
