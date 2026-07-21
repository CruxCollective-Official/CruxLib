package org.crux.processor;

import org.crux.annotations.Registry;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SupportedAnnotationTypes("org.crux.annotations.Registry")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class CruxProcessor extends AbstractProcessor {

    private final List<TypeElement> registries = new ArrayList<>();

    @Override
    public boolean process(
            Set<? extends TypeElement> annotations,
            RoundEnvironment roundEnv
    ) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Registry.class)) {
            registries.add((TypeElement) element);
        }

        if (roundEnv.processingOver()) {
            generate(registries);
        }

        return true;
    }

    private void generate(List<TypeElement> elements) {
        try {
            JavaFileObject file = processingEnv
                    .getFiler()
                    .createSourceFile("org.crux.generated.GeneratedRegistries");
            try (Writer writer = file.openWriter()) {

                StringBuilder builder = new StringBuilder();
                for (TypeElement element : elements) {
                    builder.append("new ").append(element.getQualifiedName()).append("().register(builder);\n");
                }
                String code = builder.toString();

                writer.write("""
        package org.crux.generated;
        
        import org.crux.core.CruxState;
        import org.crux.system.registry.RegistryBuilder;

        public final class GeneratedRegistries {
        
            private GeneratedRegistries() {}

            public static void register() {
                RegistryBuilder builder = CruxState.INSTANCE.getRegistryBuilder();
        """ + code +
            """
            }

        }
        """);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
