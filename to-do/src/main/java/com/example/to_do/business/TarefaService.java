package com.example.to_do.business;

import com.example.to_do.dto.TarefaAtualizacaoDTO;
import com.example.to_do.exception.TarefaInexistenteException;
import com.example.to_do.exception.UsuarioNaoEncontradoException;
import com.example.to_do.infrastructure.entity.Tarefa;
import com.example.to_do.infrastructure.repository.TarefaRepository;
import com.example.to_do.infrastructure.repository.UsuarioRepository;
import com.example.to_do.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;
    private final UsuarioRepository usuarioRepository;

    public Tarefa adicionarTarefa(Tarefa tarefa){
        if(!usuarioRepository.existsByEmail(tarefa.getEmailUsuario())) throw new UsuarioNaoEncontradoException();
        return repository.saveAndFlush(tarefa);
    }

    public Tarefa atualizarTarefa(TarefaAtualizacaoDTO tarefaAtl){
        Tarefa tarefa = repository.findById(tarefaAtl.id()).orElseThrow(
                () -> new UsuarioNaoEncontradoException());
        if(usuarioRepository.existsByEmail(tarefaAtl.emailUsuario())) {
            Tarefa tarefaAtualizada = TarefaMapper.atualizarTarefa(tarefaAtl, tarefa);
            return repository.saveAndFlush(tarefaAtualizada);
        }else throw new UsuarioNaoEncontradoException();
    }

    public void deletarTarefa(Long id){
        Tarefa tarefa = buscarTarefa(id);
        repository.deleteById(id);
    }

    public List<Tarefa> listarTodos(){
        return repository.findAll();
    }

    public List<Tarefa> listarTodasTarefasPorEmail(String email){
        if(!usuarioRepository.existsByEmail(email)) throw new UsuarioNaoEncontradoException();
        return repository.findAllByUsuarioEmail(email);
    }

    public Tarefa buscarTarefa(Long id){
        return repository.findById(id).orElseThrow(() -> new TarefaInexistenteException());
    }
}
