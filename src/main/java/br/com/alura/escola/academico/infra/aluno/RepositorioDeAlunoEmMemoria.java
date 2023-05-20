package br.com.alura.escola.academico.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoNaoEncontradoException;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeAlunoEmMemoria implements RepositorioDeAlunos {
	
	private List<Aluno>matriculados = new ArrayList<>();

	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);

	}

	@Override
	public Aluno buscarPorCPF(CPF cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().toString().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(()-> new AlunoNaoEncontradoException(cpf));
	}

	@Override
	public List<Aluno> listarTodosOsAlunosMatriculados() {
		return this.matriculados;
	}

}
