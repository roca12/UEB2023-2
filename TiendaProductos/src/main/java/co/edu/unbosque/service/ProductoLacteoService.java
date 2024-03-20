package co.edu.unbosque.service;

import java.util.ArrayList;
import java.util.List;

import co.edu.unbosque.model.ProductoLacteo;
import co.edu.unbosque.model.ProductoLacteoDTO;
import co.edu.unbosque.model.persistence.ProductoLacteoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class ProductoLacteoService implements ServiceOperation<ProductoLacteoDTO> {

	private List<ProductoLacteoDTO> products;
	private ProductoLacteoDAO pdao = new ProductoLacteoDAO();

	@PostConstruct
	public void init() {
		pdao = new ProductoLacteoDAO();
		products=new ArrayList<>();
		products = readAll();
	}

	// mappeando de entity a dto
	public ProductoLacteoDTO toDto(ProductoLacteo productoLacteo) {
		ProductoLacteoDTO dto = new ProductoLacteoDTO();
		dto.setId(productoLacteo.getId());
		dto.setNombreProducto(productoLacteo.getNombreProducto());
		dto.setEmpresaProductora(productoLacteo.getEmpresaProductora());
		dto.setCostoFabricacion(productoLacteo.getCostoFabricacion());
		dto.setCostoVenta(productoLacteo.getCostoVenta());
		dto.setLibreLactosa(productoLacteo.isLibreLactosa());
		return dto;
	}

	// mappeando de entity a dto
	public ProductoLacteo toEntity(ProductoLacteoDTO productoLacteoDto) {
		ProductoLacteo entity = new ProductoLacteo();
		entity.setId(productoLacteoDto.getId());
		entity.setNombreProducto(productoLacteoDto.getNombreProducto());
		entity.setEmpresaProductora(productoLacteoDto.getEmpresaProductora());
		entity.setCostoFabricacion(productoLacteoDto.getCostoFabricacion());
		entity.setCostoVenta(productoLacteoDto.getCostoVenta());
		entity.setLibreLactosa(productoLacteoDto.isLibreLactosa());
		return entity;
	}

	

	public List<ProductoLacteoDTO> getProducts(int size) {

		if (size > products.size()) {
			List<ProductoLacteoDTO> shortenedList = new ArrayList<>();
			for (int i = 0; i < products.size() - 1; i++) {
				shortenedList.add(products.get(i));
			}
			return shortenedList;
		}

		else {
			return new ArrayList<>(products.subList(0, size));
		}

	}

	@Override
	public void create(ProductoLacteoDTO obj) {
		pdao.create(toEntity(obj));
		products=readAll();

	}

	@Override
	public boolean delete(long id) {
		boolean result = pdao.delete(id);
		products=readAll();
		return result;
	}

	@Override
	public boolean update(long id, ProductoLacteoDTO obj) {
		boolean result = pdao.update(id, toEntity(obj));
		products=readAll();
		return result;
	}

	@Override
	public List<ProductoLacteoDTO> readAll() {
		products.clear();
		ArrayList<ProductoLacteo> entities = pdao.readAll();
		for (ProductoLacteo productoLacteo : entities) {
			products.add(toDto(productoLacteo));
		}
		return products;
	}

	@Override
	public ProductoLacteoDTO findOne(long id) {
		ProductoLacteoDTO find = toDto(pdao.findOne(id));
		return find;
	}

	public List<ProductoLacteoDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductoLacteoDTO> products) {
		this.products = products;
	}

	public ProductoLacteoDAO getPdao() {
		return pdao;
	}

	public void setPdao(ProductoLacteoDAO pdao) {
		this.pdao = pdao;
	}
	
	

}