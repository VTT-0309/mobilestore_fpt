package estore.service.upload;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	/**
	 * Lưu file upload vào thư mục với tên duy nhất được sinh tự động
	 * @param uploadFile là file upload
	 * @param storageFolder thư mục lưu file upload
	 * @return File đã lưu hoặc null
	 */
	File save(MultipartFile uploadFile, String storageFolder);
	

	/**
	 * Tạo File từ đường dẫn ảo
	 * @param virtualDir đường dẫn ảo (tính từ gốc website)
	 * @return đối tượng file
	 */
	File getFile(String virtualPath);
}
