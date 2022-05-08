package dock.service;

import dock.model.TerminalModel;
import dock.model.TerminalModelBuilder;
import dock.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {

    @Autowired
    TerminalRepository terminalRepository;

    public ResponseEntity convert(String body) {
        try {
            TerminalModel terminalModel = convertJsonToTerminalModel(body);
            return ResponseEntity
                    .accepted()
                    .body(terminalModel);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao tentar converter as mensagem enviada. Erro: " + e);
        }

    }

    public ResponseEntity save(String body) {
        try {
            TerminalModel terminalModel = convertJsonToTerminalModel(body);
            terminalRepository.save(terminalModel);

            return ResponseEntity
                    .ok()
                    .body("Terminal Salvo com sucesso!");
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao tentar salvar o Terminal. Exception: " + e);
        }
    }

    public ResponseEntity update(String body, int logic) {

        TerminalModel temp = terminalRepository.findByLogic(logic);

        TerminalModel tempBody = convertJsonToTerminalModel(body);

        if (temp == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Terminal não localizado! Por favor insira um numero logico cadastrado.");
        }

        if (tempBody.getLogic() != logic) {
            return ResponseEntity
                    .badRequest()
                    .body("Os numeros logicos não correspondem. Por favor, inserir o mesmo numero logico.");
        } else {
            terminalRepository.save(tempBody);
        }

        return ResponseEntity
                .ok()
                .body("Informações atualizadas com sucesso!");
    }

    public String[] splitText(String text) {

        String[] split = text.split(";");

        if (split != null && split.length < 10) {
            return null;
        }

        return split;
    }

    public TerminalModel convertJsonToTerminalModel(String text) {

        String[] textoSeparado = splitText(text);

        return TerminalModelBuilder
                .builder()
                .addLogic(Integer.parseInt(textoSeparado[0]))
                .addSerial(textoSeparado[1])
                .addModel(textoSeparado[2])
                .addSam(Integer.parseInt(textoSeparado[3]))
                .addPtid(textoSeparado[4])
                .addPlat(Integer.parseInt(textoSeparado[5]))
                .addVersion(textoSeparado[6])
                .addMxr(Integer.parseInt(textoSeparado[7]))
                .addMxf(Integer.parseInt(textoSeparado[8]))
                .addPverfm(textoSeparado[9])
                .build();
    }
}
