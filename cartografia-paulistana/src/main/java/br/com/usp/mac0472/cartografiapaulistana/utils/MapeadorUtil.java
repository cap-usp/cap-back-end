package br.com.usp.mac0472.cartografiapaulistana.utils;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.usp.mac0472.cartografiapaulistana.dto.obra.EnderecoResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraPageResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.dto.obra.ObraResponseDto;
import br.com.usp.mac0472.cartografiapaulistana.model.Endereco;
import br.com.usp.mac0472.cartografiapaulistana.model.Obra;
import io.micrometer.common.util.StringUtils;

public abstract class MapeadorUtil {

	public static ObraPageResponseDto mapObraToPageResponse(Obra obra, ModelMapper mapper) {
		ObraPageResponseDto obraResponse = mapper.map(obra, ObraPageResponseDto.class);
		List<String> nomesArquitetos = getNomesArquitetos(obra);
		obraResponse.setMunicipio(obra.getEndereco().getMunicipio());
		obraResponse.setArquitetosNomes(nomesArquitetos);
		return obraResponse;
	}
	
	public static ObraResponseDto mapObraToObraResponse(Obra obra, ModelMapper mapper) {
		ObraResponseDto obraResponse = mapper.map(obra, ObraResponseDto.class);
		List<String> nomesArquitetos = getNomesArquitetos(obra);
		String construtoraNome = obra.getConstrutora().getNome();
		List<String> referencias = obra.getReferencias().stream().map(referencia -> referencia.getUrl()).toList();
		EnderecoResponseDto enderecoResponse = getEnderecoResponse(obra);
		obraResponse.setArquitetosNome(nomesArquitetos);
		obraResponse.setConstrutoraObra(construtoraNome);
		obraResponse.setReferenciasObra(referencias);
		obraResponse.setEnderecoObra(enderecoResponse);
		obraResponse.setStatusObra(obra.getStatus().getNome());
		return obraResponse;
	}
	
	private static List<String> getNomesArquitetos(Obra obra){
		List<String> nomesArquitetos = obra.getArquitetos().stream()
				.map(arquiteto -> 
				new StringBuilder()
				.append(arquiteto.getNome())
				.append(StringUtils.isNotBlank(arquiteto.getNomeMeio()) ? " " + arquiteto.getNomeMeio() + " " : " ")
				.append(arquiteto.getSobrenome())
				.toString())
				.toList();
		return nomesArquitetos;
	}
	
	private static EnderecoResponseDto getEnderecoResponse(Obra obra){
		Endereco endereco = obra.getEndereco();
		var enderecoResponse = new EnderecoResponseDto();
		enderecoResponse.setEnderecoTipo(endereco.getEnderecoTipo().getNome());
		enderecoResponse.setEnderecoTitulo(endereco.getEnderecoTitulo().getNome());
		enderecoResponse.setLogradouro(endereco.getLogradouro());
		enderecoResponse.setNumero(endereco.getNumero());
		enderecoResponse.setComplemento(endereco.getComplemento());
		enderecoResponse.setCep(endereco.getCep());
		enderecoResponse.setMunicipio(endereco.getMunicipio());
		return enderecoResponse;
	}
	
}
