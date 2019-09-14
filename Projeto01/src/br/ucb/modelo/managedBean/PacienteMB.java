package br.ucb.modelo.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.ucb.modelo.Paciente;
import br.ucb.modelo.dao.PacienteDAO;
@ManagedBean(name="pacienteMB")
@SessionScoped

public class PacienteMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Paciente paciente;
	private PacienteDAO pacienteDAO;
	private List<Paciente> pacientes;

	public PacienteMB() {
		this.pacienteDAO = new PacienteDAO();
		this.pacientes = new ArrayList<>();
	}
	
    //SALVAR PACIENTE
	public String salvar() {
		if (this.pacienteDAO.incluir(this.paciente)) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Incluido com Sucesso!!");
			fc.addMessage(null, fm);
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Erro de inclusão");
			fc.addMessage(null, fm);
		}
		return this.listar();
	}

	// LISTAR PACIENTES
	public String listar() {
		this.pacientes = this.pacienteDAO.listar();
		return "tabelaPaciente";
	}

	// INCLUIR NOVO PACIENTE
	public String incluir() {
		this.paciente = new Paciente();
		return "formularioPaciente";
	}

	//EXCLUIR PACIENTE
	public void excluir(Paciente paciente) {
		if (this.pacienteDAO.excluir(paciente)) {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Excluido com Sucesso!!");
			fc.addMessage(null, fm);
		} else {
			FacesContext fc = FacesContext.getCurrentInstance();
			FacesMessage fm = new FacesMessage("Erro de exclusão");
			fc.addMessage(null, fm);
		}
		this.pacientes = this.pacienteDAO.listar();

	}
	
	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public PacienteDAO getPacienteDAO() {
		return pacienteDAO;
	}

	public void setPacienteDAO(PacienteDAO pacienteDAO) {
		this.pacienteDAO = pacienteDAO;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	
}
