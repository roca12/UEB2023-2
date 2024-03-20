package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.ProductoLacteoDTO;
import co.edu.unbosque.service.ProductoLacteoService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("productoLacteoBean")
@SessionScoped
public class ProductoLacteoBean implements Serializable{

	@Inject
	private ProductoLacteoService productoLacteoService;

	private static final long serialVersionUID = 1L;

	private List<ProductoLacteoDTO> productosEnTabla;

	private ProductoLacteoDTO productoSeleccionado;

	private List<ProductoLacteoDTO> productosSeleccionadosVarios;

	@PostConstruct
	public void init() {
		this.productosEnTabla= new ArrayList<>();
		this.productosEnTabla = productoLacteoService.getProducts();
		this.productosSeleccionadosVarios = new ArrayList<ProductoLacteoDTO>();
	}

	public void openNew() {
		this.productoSeleccionado = new ProductoLacteoDTO();
	}

	public void saveProduct() {
		if (this.productoSeleccionado.getId() == 0) {
            this.productoSeleccionado.setId(0);
            productoLacteoService.create(productoSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto lacteo agregado"));
        } else {
        	 productoLacteoService.update(productoSeleccionado.getId(), productoSeleccionado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto lacteo actualizado"));
		}
		this.productosEnTabla=productoLacteoService.getProducts();
		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteProduct() {
		productoLacteoService.delete(this.productoSeleccionado.getId());
		this.productosSeleccionadosVarios.remove(this.productoSeleccionado);
		this.productoSeleccionado = null;
		this.productosEnTabla=productoLacteoService.getProducts();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto lacteo eliminado"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

	public String getDeleteButtonMessage() {
		if (hasSelectedProducts()) {
			int size = this.productosSeleccionadosVarios.size();
			return size > 1 ? size + " productos lacteos seleccionados" : "1 producto lacteo seleccionado";
		}

		return "Eliminado";
	}

	public boolean hasSelectedProducts() {
		return this.productosSeleccionadosVarios != null && !this.productosSeleccionadosVarios.isEmpty();
	}

	public void deleteSelectedProducts() {
		for (ProductoLacteoDTO p : productosSeleccionadosVarios) {
			productoLacteoService.delete(p.getId());
		}
		this.productosSeleccionadosVarios = null;
		this.productosEnTabla=productoLacteoService.getProducts();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("productos lacteos eliminados"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

	public List<ProductoLacteoDTO> getProducts() {
		return productosEnTabla;
	}

	public void setProducts(List<ProductoLacteoDTO> products) {
		this.productosEnTabla = products;
	}

	public ProductoLacteoDTO getSelectedProduct() {
		return productoSeleccionado;
	}

	public void setSelectedProduct(ProductoLacteoDTO selectedProduct) {
		this.productoSeleccionado = selectedProduct;
	}

	public List<ProductoLacteoDTO> getSelectedProducts() {
		return productosSeleccionadosVarios;
	}

	public void setSelectedProducts(List<ProductoLacteoDTO> selectedProducts) {
		this.productosSeleccionadosVarios = selectedProducts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
