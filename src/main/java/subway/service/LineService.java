package subway.service;

import subway.constants.ErrorMessage;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.utils.CustomException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static subway.constants.ErrorMessage.ERROR_NOT_EXIST_LINE_NAME;

public class LineService {
    private final LineRepository repository;

    public LineService(LineRepository repository) {
        this.repository = repository;
    }

    public List<String> findAllLineNames(){
        return repository.lines().stream()
                .map(line -> line.getName())
                .collect(Collectors.toList());
    }

    public Line findByName(final String name){
        Optional<Line> line = repository.findByName(name);
        if(line.isEmpty()){
            throw new CustomException(ERROR_NOT_EXIST_LINE_NAME);
        }
        return line.get();
    }

    public void validateExistLine(final String name){
        Optional<Line> line = repository.findByName(name);
        if(line.isPresent()){
            throw new CustomException(ErrorMessage.ERROR_EXIST_LINE_NAME);
        }
    }

    public void validateNotExistLine(final String name){
        Optional<Line> line = repository.findByName(name);
        if(line.isEmpty()){
            throw new CustomException(ERROR_NOT_EXIST_LINE_NAME);
        }
    }

    public void deleteLine(final String name){
        repository.deleteLineByName(name);
    }

    public Line registerLine(String lineName){
        Line line = new Line(lineName);
        repository.addLine(line);
        return line;
    }
}
